import { useLocation, useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';

type Album = {
  userId: number;
  id: number;
  title: string;
};

const BASE_URL = 'https://jsonplaceholder.typicode.com';

export const AlbumList = () => {
  const location = useLocation();
  const navigate = useNavigate();

  const userId = (location.state as { userId?: number })?.userId;
  const [username, setUsername] = useState<string | null>(null);
  const [albums, setAlbums] = useState<Album[]>([]);
  const [selectedAlbumId, setSelectedAlbumId] = useState<number | null>(null);
  const [selectedAlbumTitle, setSelectedAlbumTitle] = useState<string | null>(
    null
  );

  const albumIdClick = (albumId: number, albumTitle: string) => {
    setSelectedAlbumId(albumId);
    setSelectedAlbumTitle(albumTitle);
  };

  const moveToAlbumDetail = (albumId: number) => {
    navigate(`/albumDetail/${albumId}`, {
      state: { userId, username, albumId, selectedAlbumTitle },
    });
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const userResponse = await fetch(`${BASE_URL}/users/${userId}`);
        const userData = await userResponse.json();
        setUsername(userData.username);

        const albumsResponse = await fetch(
          `${BASE_URL}/albums?userId=${userId}`
        );
        const albumsData: Album[] = await albumsResponse.json();
        setAlbums(albumsData);
      } catch (error) {
        console.error(error);
        setUsername(null);
        setAlbums([]);
      }
    };

    if (userId) {
      fetchData();
    }
  }, [userId]);

  const signOut = () => {
    navigate('/');
  };

  return (
    <>
      <header className='flex items-center justify-between p-5 bg-cyan-600 text-white'>
        <div className='text-xl font-bold mr-12'>Hanaro Album</div>

        <div className='flex space-x-4'>
          <div className='font-bold text-gray-500 text-2xl'>{userId}</div>
          <div className='font-bold text-black text-2xl'>{username}</div>
          <button className='bg-red-500 text-white' onClick={signOut}>
            Sign Out
          </button>
        </div>
      </header>

      <div className='flex items-center justify-between p-4'>
        <div className='text-2xl font-bold'>앨범 목록</div>
        <div className='ml-4'>
          <button
            className='bg-green-400 text-white'
            onClick={() =>
              selectedAlbumId
                ? moveToAlbumDetail(selectedAlbumId)
                : alert('앨범을 선택해주세요!')
            }
          >
            앨범 상세보기
          </button>
        </div>
      </div>

      <div className='p-4'>
        {albums.map((album) => (
          <div
            key={album.id}
            className={`mb-2 cursor-pointer ${
              selectedAlbumId === album.id
                ? 'border border-blue-500 text-blue-500 '
                : ''
            }`}
            onClick={() => albumIdClick(album.id, album.title)}
          >{`${album.id}. ${album.title}`}</div>
        ))}
      </div>
    </>
  );
};
