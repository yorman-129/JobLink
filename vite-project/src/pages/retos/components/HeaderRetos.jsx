import React from 'react'

const HeaderRetos = ({data}) => {
  return (
    <>
       <header className='headerHomeUsers'>
      <h1>JobLink</h1> 
      <nav>
        <ul>
          <li><a href="#">{data ? 'Reto activo':'Reto inactivo'}</a></li>
        </ul>
      </nav> 
    </header>
    </>
  )
}

export default HeaderRetos
