import React from 'react'
import HeaderHome from '../components/headerHome/HeaderHome'
import MainHome from '../components/mainHome/MainHome'
import Footer from '../components/footer/Footer'


const HomeUser = ({data}) => {
    
    return (
        <div>
            <HeaderHome data={data}/>
            <MainHome data={data}/>
            <Footer />
        </div>
    )
}

export default HomeUser
