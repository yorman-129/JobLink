import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import {createBrowserRouter,RouterProvider,} from "react-router-dom";
import Home  from './pages/home/Home.jsx'
import  Login  from './pages/login/Login.jsx'

const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    children: [
      {
        path: '',
        element: <Home />,
      },
      {
        path: '/login',
        element: <Login />,
      }
    ],
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(

  <RouterProvider router={router} />

)
