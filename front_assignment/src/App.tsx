import './App.css';
import { AlbumList } from './components/AlbumList';
import { Login } from './components/Login';
import { Route, Routes } from 'react-router-dom';

function App() {
  return (
    <Routes>
      <Route path='/' element={<Login />} />
      <Route path='/albumList' element={<AlbumList />} />
    </Routes>
  );
}

export default App;
