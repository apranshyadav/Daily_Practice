import React, { useEffect, useState } from 'react'
import axios from 'axios';
function Apicalling() {
    const [allRestaurants,setAllRestaurants]= useState([])

    useEffect(()=>{
        const API='https://www.swiggy.com/dapi/restaurants/list/v5?lat=27.6054391&lng=77.5945308&is-seo-homepage-enabled=true&page_type=DESKTOP_WEB_LISTING'
        async function calling(){
            let resp = await axios.get(API)
            // console.log(resp.data.data.cards[1].card.card.gridElements.infoWithStyle.restaurants , "resp");
            setAllRestaurants(resp.data.data.cards[1].card.card.gridElements.infoWithStyle.restaurants)
        }
        calling()
    },[])

  return allRestaurants;
}

export default Apicalling