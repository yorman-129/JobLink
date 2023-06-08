import React, { useEffect, useState } from 'react'

const MainProgreso = ({ data }) => {
  const [dataRetos, setDataRetos] = useState(null)
  useEffect(()=>{
    setDataRetos(data)
  },[])
  return (
    <>
    <ul>
      {console.log(dataRetos)}
      {dataRetos.forEach(element => {
        console.log(element)
      })}
      </ul>
    </>
  )
}

export default MainProgreso

