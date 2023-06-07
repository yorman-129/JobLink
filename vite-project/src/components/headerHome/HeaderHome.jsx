import React from 'react'
import './headerHome.css';

const HeaderHome = () => {

  const handleClick = () => {
    
  }
  return (
    <>
    <header className='headerHomeUsers'>
      <h1>JobLink</h1> 
      <nav>
        <ul>
          <li><a href="#" onClick={handleClick}>Ver Retos</a></li>
          <li><a href="#">Ver Progreso</a></li>
        </ul>
      </nav> 
    </header>
    </>
  )
}

export default HeaderHome
