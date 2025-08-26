import React, { useState } from 'react';
import axios from 'axios';

function UpdateData() {
  const [player_id, setPlayerId] = useState('');
  const [player_name, setPlayerName] = useState('');
  const [jersey_number, setJerseyNumber] = useState('');
  const [role, setRole] = useState('');
  const [total_matches, setTotalMatches] = useState('');
  const [team_name, setTeamName] = useState('');
  const [country, setCountry] = useState('');
  const [description, setDesciption] = useState('');

  const [arr, setArr] = useState([]);

  const handleSubmit = (e) => {
    e.preventDefault();

    const playerData = {
      player_id,
      player_name,
      jersey_number,
      role,
      total_matches,
      team_name,
      country,
      description,
    };

    axios
      .put(`http://localhost:8080/api/players/${player_id}`, playerData)
      .then((res) => console.log(res.data))
      .catch((err) => console.log('Cannot update player: ', err));

    setArr([...arr, playerData]);

    setPlayerId('');
    setPlayerName('');
    setJerseyNumber('');
    setRole('');
    setTotalMatches('');
    setTeamName('');
    setCountry('');
    setDesciption('');
  };

  return (
    <div className="container mt-4">
      <h1 className="mb-4 text-center">Update Player</h1>

      <form onSubmit={handleSubmit} className="row g-3">
        <div className="col-md-6">
          <input
            type="number"
            className="form-control"
            placeholder="Player ID"
            value={player_id}
            onChange={(e) => setPlayerId(e.target.value)}
            required
          />
        </div>

        <div className="col-md-6">
          <input
            type="text"
            className="form-control"
            placeholder="Player Name"
            value={player_name}
            onChange={(e) => setPlayerName(e.target.value)}
          />
        </div>

        <div className="col-md-6">
          <input
            type="text"
            className="form-control"
            placeholder="Jersey Number"
            value={jersey_number}
            onChange={(e) => setJerseyNumber(e.target.value)}
          />
        </div>

        <div className="col-md-6">
          <select
            name="role"
            value={role}
            id="role"
            className="form-select"
            onChange={(e) => setRole(e.target.value)}
          >
            <option value="">Choose a role</option>
            <option value="Batsman">Batsman</option>
            <option value="Bowler">Bowler</option>
            <option value="All-Rounder">All-Rounder</option>
            <option value="Wicket-Keeper">Wicket Keeper</option>
          </select>
        </div>

        <div className="col-md-6">
          <input
            type="number"
            className="form-control"
            placeholder="Total Matches"
            value={total_matches}
            onChange={(e) => setTotalMatches(e.target.value)}
          />
        </div>

        <div className="col-md-6">
          <input
            type="text"
            className="form-control"
            placeholder="Team Name"
            value={team_name}
            onChange={(e) => setTeamName(e.target.value)}
          />
        </div>

        <div className="col-md-6">
          <input
            type="text"
            className="form-control"
            placeholder="Country"
            value={country}
            onChange={(e) => setCountry(e.target.value)}
          />
        </div>

        <div className="col-md-12">
          <input
            type="text"
            className="form-control"
            placeholder="Description"
            value={description}
            onChange={(e) => setDesciption(e.target.value)}
          />
        </div>

        <div className="col-12 text-center">
          <button type="submit" className="btn btn-warning">
            Update Player
          </button>
        </div>
      </form>
    </div>
  );
}

export default UpdateData;
