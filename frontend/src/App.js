import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import { Venues } from './venues';
import { Performers } from './performers';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='venues' element={<Venues />}></Route>
        <Route path='performers' element={<Performers />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;