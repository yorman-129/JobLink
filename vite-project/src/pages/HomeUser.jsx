import React from 'react'
import HeaderHome from '../components/headerHome/HeaderHome'
import MainHome from '../components/mainHome/MainHome'
import Footer from '../components/footer/Footer'


const HomeUser = ({data}) => {
    console.log(data,"home user")
    return (
        <div>
            <HeaderHome />
            <MainHome data={data}/>
            <Footer />
        </div>
    )
}

export default HomeUser
