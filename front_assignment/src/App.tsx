import './App.css';
import { Route, Routes } from 'react-router-dom';
import { Login } from './components/Login';
import { AlbumList } from './components/AlbumList';
import { AlbumDetail } from './components/AlbumDetail';

function App() {
  return (
    <Routes>
      <Route path='/' element={<Login />} />
      <Route path='/albumList' element={<AlbumList />} />
      <Route path='/albumDetail/:albumId' element={<AlbumDetail />} />
    </Routes>
  );
}

export default App;
