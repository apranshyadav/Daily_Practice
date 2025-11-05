import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'

const appRouter = createBrowserRouter([
  {
    path: '/',
    element: <App/>,
    children:[
      {
      path: '/help',
      element: <Help/>
    },
    {
      path: '/signin',
      element: <Signin/>
    },
    {
      path: '/offer',
      element: <Offer/>
    }
    ]
  }
]);

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
