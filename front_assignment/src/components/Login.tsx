import { useNavigate } from 'react-router-dom';

export const Login = () => {
  const navigate = useNavigate();

  const handleLogin = () => {
    // Todo: Login
    navigate('/albumList');
  };

  return (
    <>
      <header className='flex items-center justify-between p-5 bg-cyan-600 text-white'>
        <div className='text-xl font-bold'>Hanaro Album</div>
      </header>

      <div className='flex justify-between p-4'>
        <div className='mr-4'>
          {/* <input type='number' ref={idRef} /> */}
          <input type='number' placeholder='User ID...' />
        </div>
        <button className='bg-green-400 text-white' onClick={handleLogin}>
          Sign In
        </button>
      </div>

      {/* Todo: 입력값이 1~10이 아닐 경우만 표시 */}
      <div className='text-red-500'>User ID는 1~10번만 가능합니다.</div>
    </>
  );
};
