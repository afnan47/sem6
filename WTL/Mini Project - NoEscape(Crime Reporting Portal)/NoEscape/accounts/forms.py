from .models import Video, Applicant,Camera
from django import forms
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User


class CreateUserForm(UserCreationForm):
    class Meta:
        model = User
        fields = ['username', 'email', 'password1', 'password2']

class Video_form(forms.ModelForm):
    class Meta:
        model = Video
        fields = ("name", "phone", "email", "video")


class Complaint(forms.ModelForm):
    class Meta:
        model = Applicant
        fields = ("name", "phone", "email", "complaint")


class Camera_form(forms.ModelForm):
    class Meta:
        model = Camera
        fields = ("username", "password", "ip_address")