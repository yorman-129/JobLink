import {React,useState} from 'react'

const Registro = ({handleFormRegistro}) => {
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
        handleFormRegistro(form)
    }
  return (
    <>
      <form action="" method="post">
      <h2>Registrarse</h2>
                <label htmlFor="">Correo Electronico</label>
                <input type="email" placeholder='Ejmplo@ejemplo.edu.co' name='email' onChange={handleInput}/>
                <label htmlFor="">Nombre de usuario</label>
                <input type="text" placeholder='Juanito Perez Lopez' name='nombre' onChange={handleInput}/>
                <input type="submit" className='button' onClick={handleForm}/>
        </form>
    </>
  )
}

export default Registro
