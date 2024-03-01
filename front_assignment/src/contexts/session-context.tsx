// import { ReactNode, createContext, useContext, useReducer } from 'react';

// type SessionContextProp = {
//   login: (userId: number, username: string) => boolean;
// };

// type ProviderProps = {
//   children: ReactNode;
// };

// type Action = {
//   type: 'SET_USER';
//   payload: string | number;
// };

// const SessionContext = createContext<SessionContextProp>({
//   login: () => false,
// });

// export const SessionProvider = ({ children }) => {
//   const DefaultSession = {
//     userId: null,
//     username: null,
//   };

//   const userReducer = (session: Session, { type, payload }: Action) => {
//     switch (type) {
//       case 'SET_USER':
//         return {
//           userId: session.payload.userId,
//           username: session.payload.username,
//         };
//       default:
//         return session;
//     }
//   };

//   const [login, dispatch] = useReducer(userReducer, DefaultSession);

//   return (
//     <SessionContext.Provider value={{ login }}>
//       {children}
//     </SessionContext.Provider>
//   );
// };

// export const useSession = () => useContext(SessionContext);
