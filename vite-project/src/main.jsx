import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import RetosSolucion from './pages/retos/RetosSolucion.jsx'


const Router = (<BrowserRouter>
  <Routes>
    <Route path="" element={<App />} />
    <Route path="/" element={<App />} />
    <Route path="/retoSolucion" element={<RetosSolucion />} />
  </Routes>
</BrowserRouter>)

ReactDOM.createRoot(document.getElementById('root')).render(Router)
