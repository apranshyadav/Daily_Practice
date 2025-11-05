import React from 'react'

function RestaurantCard() {
  console.log(ReadableStreamDefaultController, "rest");

  return (
    <div className='m-2 w-58'>
        <img className='w-58 h-42 rounded-2xl' src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/RX_THUMBNAIL/IMAGES/VENDOR/2025/9/1/9afabb63-f704-4437-acbf-c7a6b7a72d11_101574.JPG" />
        <div className='ml-4'>
            <h1 className='font-bold text-xl'>{restraunt.info.name}</h1>
            <span className='font-bold'>{restraunt.info.avgRating}</span>
            <span className='font-bold mx-4'>{restraunt.info.sla.slaString}</span>
            <p>{restraunt.info.cuisines[0]}</p>
            <p>{restraunt}</p>
        </div>
    </div>
  )
}

export default RestaurantCard