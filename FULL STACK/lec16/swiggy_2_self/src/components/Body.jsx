import React from 'react'
import RestaurantCard from './RestaurantCard'
import Apicalling from './Apicalling'

function Body() {
  const allRestaurants = Apicalling();
  return (
    <div className='m-12'>
        <h1 className='text-xl font-bold'>Restaurants with online food delivery in Aligarh</h1>
        <button className='border rounded-3xl m-4 p-4 text-2xl'>Rating 4.2+</button>
        <button className='border rounded-3xl m-4 p-4 text-2xl'>Reset</button>

        <div className='flex flex-wrap w-10/12 m-auto'>
            {
              allRestaurants.map((restraunt)=>{
                return(
                  <RestaurantCard restraunt={restraunt} />
                )
              })
            }
        </div>
    </div>
  )
}

export default Body