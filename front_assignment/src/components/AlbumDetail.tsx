import { useLocation, useNavigate } from 'react-router-dom';

export const AlbumDetail = () => {
  const location = useLocation();
  const navigate = useNavigate();

  const userId = (location.state as { userId?: number })?.userId;
  const username = (location.state as { username?: string | null })?.username;
  const albumId = (location.state as { albumId?: number })?.albumId;
  const albumTitle = (location.state as { selectedAlbumTitle?: string | null })
    ?.selectedAlbumTitle;

  const signOut = () => {
    navigate('/');
  };

  return (
    <>
      <header className='flex items-center justify-between p-5 bg-cyan-600 text-white'>
        <div className='text-xl font-bold mr-12'>Hanaro Album</div>

        <div className='flex space-x-4'>
          <div className='font-bold text-gray-500'>{userId}</div>
          <div className='font-bold text-black'>{username}</div>
          <button className='bg-red-500 text-white' onClick={signOut}>
            Sign Out
          </button>
        </div>
      </header>

      <div className='font-bold p-5'>{`${albumTitle} ${albumId}`}</div>
    </>
  );
};
