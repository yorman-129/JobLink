import React, { useState } from 'react'
import './estilos.css'

const Inicio = ({handleFormInicio}) => {
    const [form, setForm]=useState(null)

    const handleInput=(e)=>{
        const nameInput= e.target.name;
        setForm({
            ...form,
            [nameInput]:e.target.value
        })
    }
    const handleForm=(e)=>{
        e.preventDefault();
        handleFormInicio(form)
    }
    return (
        <>
            <form >

                <h2>Inicar sesion</h2>
                <label htmlFor="">Correo Electronico</label>
                <input type="email" placeholder='Ejemplo@ejemplo.edu.co' name="email" onChange={handleInput}/>

                <input type="submit" className='button' onClick={handleForm}/>
            </form>
        </>
    )
}

export default Inicio
