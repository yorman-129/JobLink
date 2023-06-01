import React from 'react';
import './retosEstilo.css';

const MainRetos = ({data}) => {
  const Color = ()=>{
    if (data.dificultad==='Alto'){
      return 'red'
    }else if(data.dificultad==='Medio'){
      return 'yellow'
    }else{
      return 'green'
    }
  }

  return (
    <>
      <div className="card">
        <h2 className='h2'>{data.empresa?.nombre}</h2>
        <p className='a'style={{color: Color()}}>Nivel {data.dificultad}</p>
        <p className='p'>{data.descripcion}</p>
        <input className='input' type="file" name="" id="" />
        <input  className='inputSubmit' type="submit" value="Enviar" />
      </div>
    </>
  )
}

export default MainRetos
