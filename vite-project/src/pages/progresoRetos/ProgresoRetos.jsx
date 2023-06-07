import React from 'react'
import HeaderHome from '../../components/headerHome/HeaderHome'
import MainProgreso from './mainProgreso'
import Footer from '../../components/footer/Footer'
import { useParams } from 'react-router-dom';


const ProgresoRetos = () => {
    const { id } = useParams();
    console.log(id)
    return (
        <>
            <HeaderHome />
            <MainProgreso data={id}/>
            <Footer/>
        </>

    )
}

export default ProgresoRetos
