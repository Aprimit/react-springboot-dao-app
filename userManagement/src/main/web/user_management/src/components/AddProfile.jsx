import React from 'react';

export default class AddProfile extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            name: '',
            description: ''
        }
        this.handleNameChange = this.handleNameChange.bind(this);
        this.handleDescChange = this.handleDescChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }
    handleNameChange(e) {
        this.setState({
            name: e.target.value
        })
    }
    handleDescChange(e) {
        this.setState({
            description: e.target.value
        })
    }
    handleClick(){
        let newProfile ={
            name: this.state.name,
            description: this.state.description
        }
        this.props.addProfile(newProfile);
    }
    render() {
        return (
            <div>
                <input onChange={this.handleNameChange} value={this.state.name} />
                <input onChange={this.handleDescChange} value={this.state.description} />
                <button onClick={this.handleClick}>Add Profile</button>
            </div>
        );
    }
}