import React, { useEffect, useState } from 'react';

const MainProgreso = ({ data }) => {
  const [dataRetos, setDataRetos] = useState(null);

  useEffect(() => {
    setDataRetos(data);
  }, [data]);

  return (
    <>
      <ul>
        {dataRetos &&
          dataRetos.map((reto, index) => (
            <li key={index}>{reto.id}</li>
          ))}
      </ul>
    </>
  );
};

export default MainProgreso;