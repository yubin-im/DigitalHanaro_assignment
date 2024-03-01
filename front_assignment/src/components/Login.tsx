import { useState, useRef } from 'react';
import { useNavigate } from 'react-router-dom';

export const Login = () => {
  const navigate = useNavigate();
  const idRef = useRef<HTMLInputElement | null>(null);
  const [error, setError] = useState<string | null>(null);

  const handleLogin = () => {
    const id = Number(idRef.current?.value);

    if (!idRef.current || !idRef.current.value) {
      setError('User ID를 입력해주세요!');
      idRef.current?.focus();
      return;
    } else if (id >= 1 && id <= 10) {
      setError(null);
      navigate('/albumList');
    } else {
      setError('User ID는 1~10번만 가능합니다.');
      idRef.current?.focus();
    }
  };

  return (
    <>
      <header className='flex items-center justify-between p-5 bg-cyan-600 text-white'>
        <div className='text-xl font-bold'>Hanaro Album</div>
      </header>

      <div className='flex justify-between p-4'>
        <div className='mr-4'>
          <input type='number' placeholder='User ID...' ref={idRef} />
        </div>
        <button className='bg-green-400 text-white' onClick={handleLogin}>
          Sign In
        </button>
      </div>

      {error && <div className='text-red-500'>{error}</div>}
    </>
  );
};
