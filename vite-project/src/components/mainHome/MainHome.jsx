import React from 'react'
import './mainHome.css';

const MainHome = () => {
  return (
    <>
      <main>
      <section>
        <h2>Bienvenido a la Plataforma de Retos.</h2>
        <p>Esta es una plataforma donde podrás encontrar retos proporcionados por empresas del Oriente Antioqueño. Completa los retos y recibe una certificación de experiencia. </p>
      </section>
      <section>
        <h2>Últimos Retos</h2>
        <ul id="retos">
          <li>
            <h3>Retos de Empresa A</h3>
            <p>Descripción del reto de la Empresa A</p>
            <button class="comenzar-reto">Comenzar Reto</button>
          </li>
          <li>
            <h3>Retos de Empresa B</h3>
            <p>Descripción del reto de la Empresa B</p>
            <button class="comenzar-reto">Comenzar Reto</button>
          </li>
        </ul>
      </section>
    </main>
    </>
  )
}

export default MainHome
