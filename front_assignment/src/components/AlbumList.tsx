import { useLocation } from 'react-router-dom';
import { useEffect, useState } from 'react';

export const AlbumList = () => {
  const location = useLocation();
  const userId = (location.state as { userId?: number })?.userId;
  const [username, setUsername] = useState<string | null>(null);

  useEffect(() => {
    const fetchUsername = async () => {
      try {
        const response = await fetch(
          `https://jsonplaceholder.typicode.com/users/${userId}`
        );
        const data = await response.json();
        setUsername(data.username);
      } catch (error) {
        console.error(error);
        setUsername(null);
      }
    };

    if (userId) {
      fetchUsername();
    }
  }, [userId]);

  const handleSignOut = () => {
    alert('로그아웃');
  };

  return (
    <>
      <header className='flex items-center justify-between p-5 bg-cyan-600 text-white'>
        <div className='text-xl font-bold mr-12'>Hanaro Album</div>

        <div className='flex space-x-4'>
          <div className='font-bold text-gray-500'>{userId}</div>
          <div className='font-bold text-black'>{username}</div>
          <button className='bg-red-500 text-white' onClick={handleSignOut}>
            Sign Out
          </button>
        </div>
      </header>

      <div className='flex items-center justify-between p-4'>
        <div className='text-2xl font-bold'>앨범 목록</div>
        <div className='ml-4'>
          <button className='bg-green-400 text-white'>앨범 상세보기</button>
        </div>
      </div>
    </>
  );
};
