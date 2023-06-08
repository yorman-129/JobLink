import React, { useEffect, useState } from 'react';
<<<<<<< HEAD

const MainProgreso = ({ data }) => {
  const [dataRetos, setDataRetos] = useState(null);

=======
import axios from 'axios';

const MainProgreso = ({ data }) => {
  const [dataRetos, setDataRetos] = useState(null);
  
>>>>>>> 59dd180704ac159e1ca90302c6ac167ecbc61504
  useEffect(() => {
    setDataRetos(data);
  }, [data]);

<<<<<<< HEAD
=======
  const handleButton=async(id)=>{
    try {
      const response = await axios.get(`http://localhost:8087/retos/${id}/solucion`, {
        responseType: 'blob',
      });

      const downloadUrl = window.URL.createObjectURL(new Blob([response.data]));
      const link = document.createElement('a');
      link.href = downloadUrl;
      link.setAttribute('download', 'solucion.zip');
      document.body.appendChild(link);
      link.click();
      link.remove();
      window.URL.revokeObjectURL(downloadUrl);
    } catch (error) {
      console.error('Error al descargar la solución:', error);
    }
  }

>>>>>>> 59dd180704ac159e1ca90302c6ac167ecbc61504
  return (
    <>
      <ul>
        {dataRetos &&
          dataRetos.map((reto, index) => (
<<<<<<< HEAD
            <li key={index}>{reto.id}</li>
=======
            <li key={index}>
              <div>{reto.id}</div>
              <div>{reto.empresa.nombre}</div>
              <div>{reto.estado ? 'activo':'inactivo'}</div>
              <div><button onClick={handleButton(reto.id)}>Descargar Solucion</button></div>
              </li>
>>>>>>> 59dd180704ac159e1ca90302c6ac167ecbc61504
          ))}
      </ul>
    </>
  );
};

export default MainProgreso;