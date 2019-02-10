import React from 'react';
import ReactDOM from 'react-dom';
import logo from './../logo.svg';
import './../App.css';
import User from './User'
import AddUser from './AddUser';
import { getUsers } from './../utils/userApi';

class App extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      users: []
    }
    this.addUser = this.addUser.bind(this);
  }
  addUser(newUser) {
    this.setState({ Users: this.state.users.concat([newUser]) })
  }
  // componentDidMount() {
  //   getUsers().then(users => {
  //     this.setState({
  //       users: users
  //     })
  //     console.log(users)
  //   }).catch(err => console.log(err))
  // }
  render() {
    getUsers().then(users => {
      this.setState({
        users: users
      })
      console.log(users)
    }).catch(err => console.log(err))
    let Users = this.state.users.map(user => {
      return (
        <User username={user.username} firstname={user.firstname} />
      );
    })
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          {Users}
          <AddUser addUser={this.addUser}></AddUser>
          <br />
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
      </div>
    );
  }
}
ReactDOM.render(<App />, document.getElementById('root'));
export default App;
