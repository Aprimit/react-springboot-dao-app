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
        this.handleFirstnameChange = this.handleFirstnameChange.bind(this);
        this.handleLastnameChange= this.handleLastnameChange.bind(this);
        this.handleOrganizationChange = this.handleOrganizationChange.bind(this);
        this.handleDepartmentChange = this.handleDepartmentChange.bind(this);
        this.handleDesignationChange = this.handleDesignationChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }
    handleUsernameChange(e) {
        this.setState({
            username: e.target.value
        })
    }
    handleFirstnameChange(e) {
        this.setState({
            firstname: e.target.value
        })
    }
    handleLastnameChange(e) {
        this.setState({
            lastname: e.target.value
        })
    }
    handleOrganizationChange(e) {
        this.setState({
            organization: e.target.value
        })
    }
    handleDepartmentChange(e) {
        this.setState({
            department: e.target.value
        })
    }
    handleDesignationChange(e) {
        this.setState({
            designation: e.target.value
        })
    }
    handleClick() {
        let newUser = {
            username: this.state.username,
            firstname: this.state.firstname,
            lastname: this.state.lastname,
            organization: this.state.organization,
            department: this.state.department,
            designation: this.state.designation
        }
        this.props.addUser(newUser);
    }
    render() {
        return (
            <div>
                <input onChange={this.handleUsernameChange} value={this.state.username} />
                <input onChange={this.handleFirstnameChange} value={this.state.firstname} />
                <input onChange={this.handleLastnameChange} value={this.state.lastname} />
                <input onChange={this.handleOrganizationChange} value={this.state.organization} />
                <input onChange={this.handleDepartmentChange} value={this.state.department} />
                <input onChange={this.handleDesignationChange} value={this.state.designation} />
                <button onClick={this.handleClick}>Add Profile</button>
            </div>
        );
    }
}