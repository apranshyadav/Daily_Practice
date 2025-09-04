import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import Span, {App , Div} from './App.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
    <Div />
    <Span />
  </StrictMode>,
)


// import { StrictMode } from 'react'
// import { createRoot } from 'react-dom/client'
// import './index.css'
// // import Div from './App.jsx'
// // import Span from './App.jsx'
// // import Divvv from './App.jsx'
// import Span, {Div, App} from './App.jsx'
// // import Cat from './components/Cat.jsx'
// // import Dog from './components/Dog.jsx' 

// createRoot(document.getElementById('root')).render(
//   <StrictMode>
//     {/* <App /> */}
//     {/* <App></App> */}
//     <Div />
    
//     <Span />
//     {/* <Divvv /> */}
//     <App />

//     {/* <Cat />
//     <Dog /> */}
//   </StrictMode>,
// )
