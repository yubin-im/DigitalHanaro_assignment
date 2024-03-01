import { useLocation, useNavigate } from 'react-router-dom';

type AlbumDetailProps = {
  userId: number;
  username: string | null;
  albumId: number | null;
  albumTitle: string | null;
};

export const AlbumDetail = ({
  userId,
  username,
  albumId,
  albumTitle,
  ...props
}: AlbumDetailProps) => {
  const location = useLocation();
  const navigate = useNavigate();

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

      <div>{`${albumTitle}`}</div>
      <div>{`${albumId}`}</div>
    </>
  );
};
