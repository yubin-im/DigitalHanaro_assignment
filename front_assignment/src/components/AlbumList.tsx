export const AlbumList = () => {
  return (
    <>
      <header className='flex items-center justify-between p-5 bg-cyan-600 text-white'>
        <div className='text-xl font-bold mr-12'>Hanaro Album</div>

        <div className='flex space-x-4'>
          <div className='font-bold text-gray-500'>아이디</div>
          <div className='font-bold text-black'>이름</div>
          <button className='bg-red-500 text-white'>Sign Out</button>
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