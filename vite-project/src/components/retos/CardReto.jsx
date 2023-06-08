import React from 'react'
import { useNavigate } from 'react-router-dom'

const CardReto = ({data,description,dificultad,empresa,id, onClick}) => {
  
    const navigate = useNavigate();
    const handleButton = (evento)=>{
      navigate(`/retoSolucion/${id}`, { state: { loginData: data } })
      onClick(evento)
    }
  return (
    <>
       <li key={id}>
              <h4>{empresa?.nombre}</h4>
              <p>{description}</p>
              <p>{dificultad}</p>
              <a href="#" className="comenzar-reto" onClick={handleButton} >Comenzar Reto</a>
        </li>
    </>
  )
}

export default CardReto
