import React from 'react';

export default class AddUser extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            username: '',
            firstname: '',
            lastname: '',
            organization: '',
            department: '',
            designation: ''
        }
        this.handleUsernameChange = this.handleUsernameChange.bind(this);
        this.handlefirstnameChange = this.handlefirstnameChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }
    handleUsernameChange(e) {
        this.setState({
            username: e.target.value
        })
    }
    handlefirstnameChange(e) {
        this.setState({
            firstname: e.target.value
        })
    }
    handleClick() {
        let newUser = {
            username: this.state.username,
            firstname: this.state.firstname
        }
        this.props.addUser(newUser);
    }
    render() {
        return (
            <div>
                <input onChange={this.handleUsernameChange} value={this.state.username} />
                <input onChange={this.handlefirstnameChange} value={this.state.firstname} />
                <button onClick={this.handleClick}>Add Profile</button>
            </div>
        );
    }
}