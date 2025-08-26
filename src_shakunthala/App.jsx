import DisplayData from "./components/DisplayData";
import UpdateData from "./components/UpdateData";
import PostData from "./components/PostData";
import MinMax from "./components/MinMax";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
    <>
      <BrowserRouter>
        <div className="container mt-4">
          <h1 className="text-center mb-4">Player Management System</h1>
          <nav className="navbar navbar-expand-lg navbar-light bg-light rounded shadow-sm mb-4">
            <div className="container-fluid">
              <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                <li className="nav-item">
                  <Link className="nav-link" to="/get">
                    View Players
                  </Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link" to="/post">
                    Add Player
                  </Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link" to="/update">
                    Update Player
                  </Link>
                </li>
                 <li className="nav-item">
                  <Link className="nav-link" to="/getminmax">
                   Get Min Max
                  </Link>
                </li>
              </ul>
            </div>
          </nav>

          
          <div className="card p-4 shadow-sm">
            <Routes>
              <Route path="/get" element={<DisplayData />} />
              <Route path="/post" element={<PostData />} />
              <Route path="/update" element={<UpdateData />} />
              <Route path="/getminmax" element={<MinMax />} />
             
            </Routes>
          </div>
        </div>
      </BrowserRouter>
    </>
  );
}

export default App;
