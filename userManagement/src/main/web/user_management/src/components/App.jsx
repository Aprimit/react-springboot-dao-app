import React from 'react';
import ReactDOM from 'react-dom';
import logo from './../logo.svg';
import './../App.css';
import Profile from './Profile'
import AddProfile from './AddProfile';

class App extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      profiles: [{ "name": "A1", "description": "Test Profile 1" }, { "name": "A2", "description": "Test Profile 2" }]
    }
    this.addProfile = this.addProfile.bind(this);
  }
  addProfile(newProfile) {
    this.setState({ profiles: this.state.profiles.concat([newProfile]) })
  }
  render() {
    let profiles = this.state.profiles.map(profile => {
      return (
        <Profile name={profile.name} desc={profile.description} />
      );
    })
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          {profiles}
          <AddProfile addProfile={this.addProfile}></AddProfile>
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
