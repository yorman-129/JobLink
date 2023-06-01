import React from 'react'

const CardReto = ({description,dificultad,empresa,id, onClick}) => {

    const handleButton = (evento)=>{
        onClick(evento)
    }
  return (
    <>
       <li key={id}>
              <h4>{empresa?.nombre}</h4>
              <p>{description}</p>
              <p>{dificultad}</p>
              <a href={`./retoSolucion/${id}`} className="comenzar-reto" onClick={handleButton} >Comenzar Reto</a>
        </li>
    </>
  )
}

export default CardReto
