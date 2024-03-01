import { useLocation, useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';

type Photo = {
  albumId: number;
  id: number;
  title: string;
  url: string;
  thumbnailUrl: string;
};

const BASE_URL = 'https://jsonplaceholder.typicode.com';

export const AlbumDetail = () => {
  const location = useLocation();
  const navigate = useNavigate();

  const userId = (location.state as { userId?: number })?.userId;
  const username = (location.state as { username?: string | null })?.username;
  const albumId = (location.state as { albumId?: number })?.albumId;
  const albumTitle = (location.state as { selectedAlbumTitle?: string | null })
    ?.selectedAlbumTitle;

  const [photos, setPhotos] = useState<Photo[]>([]);

  const signOut = () => {
    navigate('/');
  };

  const goBack = () => {
    navigate('/albumList', { state: { userId, username } });
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const photoResponse = await fetch(
          `${BASE_URL}/photos?albumId=${albumId}`
        );
        const data: Photo[] = await photoResponse.json();
        setPhotos(data);
      } catch (error) {
        console.error(error);
        setPhotos([]);
      }
    };

    if (albumId) {
      fetchData();
    }
  }, [albumId]);

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

      <div className='text-2xl font-bold p-5 bg-yellow-100'>{`${albumTitle} ${albumId}`}</div>

      <div className='flex flex-wrap p-4'>
        {photos.map((photo) => (
          <div key={photo.id} className='w-1/4 p-2'>
            <img
              src={photo.thumbnailUrl}
              alt={photo.title}
              className='w-40 h-40 object-cover'
            />
          </div>
        ))}
      </div>

      <button className='bg-blue-500 text-white p-4 mt-4' onClick={goBack}>
        뒤로
      </button>
    </>
  );
};
