import './CRUDTable.css'
import CRUDTable,
{
  Fields,
  Field,
  CreateForm,
  UpdateForm,
  DeleteForm,
} from 'react-crud-table';
import "./index.css";
import { Link } from 'react-router-dom';
import { VenueController } from './venueController';
import React, { useState } from 'react';

const styles = {
    container: { margin: "auto", width: "fit-content" }
  };


const DescriptionRenderer = ({ field }) => <textarea {...field} />;

export function Venues() {

    const [createError, setCreateError] = useState(null);

    const handleCreateVenue = async (id) => {
        try {
            await VenueController.createVenue(id);
        } catch (error) {
            console.error('Create venue error:', error);
            setCreateError("Failed to create venue. Provide the performer's Id ");
            alert("You have to provide the performer's Id")
        }
    };

    return (
        <div style={styles.container}> 
            <Link to='/performers'>Performers</Link>
            <CRUDTable caption='Venues' fetchItems={() => VenueController.getAll()}>
                <Fields>
                    <Field name="venueId" label="Id" hideInCreateForm readOnly />
                    <Field name="venueName" label="Name" placeholder="Name" />
                    <Field name='venueLocation' label='Location Name' placeholder='Location' />
                    <Field name="price" label="Price" />
                    <Field name="performerId" label="Performer ID" />
                </Fields>
                <CreateForm 
                    title='Venue Creator' message='Add a new Venue' 
                    trigger='Add Venue' onSubmit={handleCreateVenue} submitText='Create'/>
                <UpdateForm 
                    title='Update venue' message='Update the venue' 
                    trigger='Update' onSubmit={VenueController.updateVenue} submitText='Update'/>    
                <DeleteForm 
                    title='Delete venue' message='Delete the venue' 
                    trigger='Delete' onSubmit={VenueController.deleteVenue} submitText='Delete'/>
            </CRUDTable>
        </div>
    )
}