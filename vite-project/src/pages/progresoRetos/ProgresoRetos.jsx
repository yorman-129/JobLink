import React from 'react'
import HeaderHome from '../../components/headerHome/HeaderHome'
import Footer from '../../components/footer/Footer'
import { useParams } from 'react-router-dom';
import MainProgreso from './mainProgreso';


const ProgresoRetos = () => {
    const { id } = useParams();
    console.log(id)
    return (
        <>
            <HeaderHome />
            <MainProgreso/>
            <Footer/>
        </>

    )
}

export default ProgresoRetos
