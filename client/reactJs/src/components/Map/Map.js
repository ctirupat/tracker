import React, { Component } from 'react';
import {Table,TableBody, TableHeader, TableHeaderColumn, TableRow, TableRowColumn} from 'material-ui/Table';
import moment from 'moment';
import {Gmaps, Marker} from 'react-gmaps';
import axios from 'axios';
const params = {v: '3.exp', key: 'AIzaSyCXLpoBVlrVtPMS6Fa44_Y9MkXXeSDSDA4'};
class Map extends Component{
    constructor (props) {
        super();
        this.state={readings:[]}
    }
    getInitialState() {
        return {
            readings:[]
        }
    }

    componentDidMount(){
        let self=this;
        let vin=self.props.name;
        let temp=[]
        const readingUrl = 'http://localhost:8080/api/readings/'+ vin;
        axios.get(readingUrl)
            .then(function (response) {
                for(let i=0;i<response.data.length;i++){
                    if( ((Date.now()-new Date(response.data[i].timestamp))/60000)< 30){
                        temp.push(response.data[i]);
                    }
                }
                self.setState({
                    readings:temp
                });



            })
            .catch(function (error) {
                console.log(error);
            });

    }
    render(){
        return(
            <div>

                <Gmaps
                    width={'800px'}
                    height={'600px'}
                    lat={41.8781}
                    lng={87.6298}
                    zoom={2}
                    params={params}
                    >
                    {this.state.readings.map((reading,i)=>
                        <Marker key={i}
                                lat={reading.latitude}
                                lng={reading.longitude}
                                 />
                    )}
                </Gmaps>
            </div>

        );
    }
}
export default Map;