import React from 'react'
import HomeUser from './pages/HomeUser'
import './App.css'

function App() {


  return (
    <>
    <MiContexto.Provider value={data}>
    <HomeUser/>
    </MiContexto.Provider>
    </>
  )
}

export default App
