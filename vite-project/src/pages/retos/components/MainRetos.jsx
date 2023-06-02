import React, { useState } from 'react';
import './retosEstilo.css';
import axios from 'axios';

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

  const [reto, setReto]=useState(null)

  const handleReto = (event)=>{
    
    setReto(event.target.files[0])
  }
  
  const sendData = ()=>{
    console.log("datos a enviar", reto);
    const formData = new FormData();
    formData.append('file', reto);
    formData.append('mail', data.email);
    console.log("XXXXXXXXXXXXXXXXXX",formData);
    axios.post(`http://localhost:8087/retos/${data.id}/solucion`, formData)
    setReto(null);
  }

  return (
    <>
      <div className="card">
        <h2 className='h2'>{data.empresa?.nombre}</h2>
        <p className='a'style={{color: Color()}}>Nivel {data.dificultad}</p>
        <p className='p'>{data.descripcion}</p>
   
        <input className='input' type="file" accept=".zip"  name="file" id="" onChange={handleReto}/>
        <input  className='inputSubmit' type="submit" onClick={sendData} value="Enviar" />

      </div>
    </>
  )
}

export default MainRetos
