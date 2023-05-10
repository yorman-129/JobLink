import React from 'react'

const CardReto = ({description,dificultad,empresa,id, onClick}) => {

    const handleButton = (evento)=>{
        evento.preventDefault();
        onClick(evento.target)
    }
  return (
    <>
       <li key={id}>
              <h3>{empresa.nombre}</h3>
              <p>{description}</p>
              <p>{dificultad}</p>
              <button className="comenzar-reto" id={id} onClick={handleButton}>Comenzar Reto</button>
        </li>
    </>
  )
}

export default CardReto
