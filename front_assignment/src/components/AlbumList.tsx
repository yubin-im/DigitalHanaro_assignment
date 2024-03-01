export const AlbumList = () => {
  const handleSignOut = () => {
    alert('로그아웃');
  };

  return (
    <>
      <header className='flex items-center justify-between p-5 bg-cyan-600 text-white'>
        <div className='text-xl font-bold mr-12'>Hanaro Album</div>

        <div className='flex space-x-4'>
          <div className='font-bold text-gray-500'>id</div>
          <div className='font-bold text-black'>name</div>
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
