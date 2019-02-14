import React from 'react';
import ReactDOM from 'react-dom';
import logo from './../logo.svg';
import './../App.css';
import User from './User'
import AddUser from './AddUser';
import { getUsers, addNewUser } from './../utils/userApi';

class App extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      users: []
    }
    this.addUser = this.addUser.bind(this);
  }
  async addUser(newUser) {
    var data = await addNewUser(newUser);
    if (data.status == 201) {
      this.setState((prevState) => ({ users: [...prevState.users, newUser] }))
    }
  }
  componentDidMount() {
    getUsers().then(users => {
      this.setState({
        users: users
      })
      console.log(users)
    }).catch(err => console.log(err))
  }
  render() {
    let Users = this.state.users.map((user, index) => {
      return (
        <User key={index} username={user.username} firstname={user.firstname} lastname={user.lastname} organization={user.organization} department={user.department} designation={user.designation} />
      );
    })
    return (
      <div className="App">
        <header className="App-header">
          {/* Fragment is used to group table entities */}
          <React.Fragment>
            <table border="1px solid white">
              <thead>
                <tr>
                  <th>USERNAME</th>
                  <th>FIRSTNAME</th>
                  <th>LASTNAME</th>
                  <th>ORGANIZATION</th>
                  <th>DEPARTMENT</th>
                  <th>DESIGNATION</th>
                </tr>
              </thead>
              <tbody>
                {Users}
              </tbody>
            </table>
          </React.Fragment>
          <AddUser addUser={this.addUser}></AddUser>
          <br />
        </header>
      </div>
    );
  }
}
ReactDOM.render(<App />, document.getElementById('root'));
export default App;
