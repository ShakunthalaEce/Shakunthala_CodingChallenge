import React, { useState, useEffect } from 'react';
import axios from "axios";

function DisplayData() {
  const [players, setPlayers] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/players")
      .then((res) => setPlayers(res.data))
      .catch((err) => console.log("Cannot fetch data : ", err));
  }, []);

  return (
    <div className="container mt-4">
      <h2 className="mb-4 text-center">View Players</h2>

      <div className="table-responsive">
        <table className="table table-bordered table-striped table-hover">
          <thead className="table-dark">
            <tr>
              <th>Player ID</th>
              <th>Player Name</th>
              <th>Jersey Number</th>
              <th>Role</th>
              <th>Total Matches</th>
              <th>Team Name</th>
              <th>Country</th>
              <th>Description</th>
            </tr>
          </thead>
          <tbody>
            {players.map((player) => (
              <tr key={player.player_id}>
                <td>{player.player_id}</td>
                <td>{player.player_name}</td>
                <td>{player.jersey_number}</td>
                <td>{player.role}</td>
                <td>{player.total_matches}</td>
                <td>{player.team_name}</td>
                <td>{player.country}</td>
                <td>{player.description}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default DisplayData;
