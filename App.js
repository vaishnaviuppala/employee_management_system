import logo from './logo.svg';
import './App.css';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import {BrowserRouter as Router,Route,Routes} from 'react-router-dom';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';
import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';

function App() {
  return (
    <div className="App">
      <HeaderComponent></HeaderComponent>

      <Router>
      <div className='container mt-4'>
        <Routes>
          <Route exact path='/' element={<ListEmployeeComponent/>} />
           <Route path='/employees' element={<ListEmployeeComponent/>} /> 
           <Route path='/add-employee' element={<CreateEmployeeComponent/>}/>
           <Route path='/update-employee/:id' element={<UpdateEmployeeComponent/>}/>
        </Routes>
     </div>
     </Router>

     <FooterComponent></FooterComponent>
    </div>
  );
}

export default App;
