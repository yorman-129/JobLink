import React from 'react'

const CardReto = ({tittle,description,id, onClick}) => {
    
    const handleButton = (evento)=>{
        evento.preventDefault();
        onClick(evento.target)
    }
  return (
    <>
       <li key={id}>
              <h3>{tittle}</h3>
              <p>{description}</p>
              <button className="comenzar-reto" id={id} onClick={handleButton}>Comenzar Reto</button>
        </li>
    </>
  )
}

export default CardReto
