import axios from "axios";
import { useState } from "react";
function MinMax()
{

    const[minMatches,setMinMatches]=useState('');
    const[maxMatches,setMaxMatches]=useState('');
    const[playerData,setPlayerData]=useState([]);

    const handleSubmit=(e)=>{
        e.preventDefault();
        axios.get(`http://localhost:8080/api/players/getPlayersbetween/${minMatches}/${maxMatches}`)
        .then((res)=>setPlayerData(res.data))
        .catch((err)=>console.log("Error in fetching the data: ",err));
    }
    return(
        <>
            
    <div className="container mt-4">
      <h1 className="mb-4 text-center">Get Matches Played </h1>

      <form onSubmit={handleSubmit} className="row g-3">
        <div className="col-md-6">
          <input
            type="number"
            className="form-control"
            placeholder="Min Matches Played"
            value={minMatches}
            onChange={(e) => setMinMatches(e.target.value)}
            required
          />
        </div>

        <div className="col-md-6">
          <input
            type="number"
            className="form-control"
            placeholder="Max Matches Played"
            value={maxMatches}
            onChange={(e) => setMaxMatches(e.target.value)}
          />
        </div>
         <div className="col-12 text-center">
          <button type="submit" className="btn btn-primary">
            Get Players
          </button>
        </div>
      </form>
       <table className="table table-bordered">
        <thead>
          <tr>
            <th>Player ID</th>
            <th>Name</th>
            <th>Matches</th>
            <th>Role</th>
          </tr>
        </thead>
        <tbody>
          {
            playerData.map((p) => (
              <tr key={p.player_id}>
                <td>{p.player_id}</td>
                <td>{p.player_name}</td>
                <td>{p.total_matches}</td>
                <td>{p.role}</td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>
        </>
    )
}
export default MinMax;
