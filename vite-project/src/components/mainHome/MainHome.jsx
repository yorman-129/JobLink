import React, { useState } from 'react'
import CardReto from '../retos/CardReto';
import './mainHome.css';

const MainHome = () => {
  const [retos, setReto]=useState([
    {
      nombreEmpresa: 'Renault',
      idreto: 1,
      problema: `Lorem ipsum dolor sit amet consectetur adipisicing elit.
       Eos dolorem inventore animi rem distinctio est recusandae sint? Consectetur, aut ea tempora rem unde,
       et id architecto cumque hic, laudantium quibusdam.`
    },
    {
      nombreEmpresa: 'Facebook',
      idreto: 2,
      problema: `Lorem ipsum dolor sit amet consectetur adipisicing elit.
      Eos dolorem inventore animi rem distinctio est recusandae sint? Consectetur, aut ea tempora rem unde,
      et id architecto cumque hic, laudantium quibusdam.`
    }
  ]) 

  const handleReto = (evento) => {
    console.log('exitoso')
  }

  return (
    <>
      <main className='container-main'>
        <section className='container-section'>
          <h2>Bienvenido a la Plataforma de Retos.</h2>
          <p>Esta es una plataforma donde podrás encontrar retos proporcionados por empresas del Oriente Antioqueño. Completa los retos y recibe una certificación de experiencia. </p>
        </section>
        <section className='container-section'>
          <h2>Últimos Retos</h2>
          <ul className='retos'>
            

            {retos.map((reto) =>{
              return <CardReto tittle={reto.nombreEmpresa} description={reto.problema} id={reto.idreto} onClick={handleReto}/>
            })}
            
          </ul>
        </section>
      </main>
    </>
  )
}

export default MainHome
